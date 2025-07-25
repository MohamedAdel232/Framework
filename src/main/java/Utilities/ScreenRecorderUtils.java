package Utilities;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.AudioFormatKeys.EncodingKey;
import static org.monte.media.AudioFormatKeys.FrameRateKey;
import static org.monte.media.AudioFormatKeys.KeyFrameIntervalKey;
import static org.monte.media.AudioFormatKeys.MIME_AVI;
import static org.monte.media.AudioFormatKeys.MediaTypeKey;
import static org.monte.media.AudioFormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtils extends ScreenRecorder {
    public static ScreenRecorder screenRecorder;
    public static String screenRecordingsDirectoryPath = "TestOutputs/ScreenRecordings/";
    public String name;


    public ScreenRecorderUtils(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                               Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    public static void startRecording(String methodName) {
        if (PropertiesUtils.getPropertyValue("screenRecord").equalsIgnoreCase("true")
                && PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            File file = new File(screenRecordingsDirectoryPath);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;

            Rectangle captureSize = new Rectangle(0, 0, width, height);

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice()
                    .getDefaultConfiguration();
            try {
                screenRecorder = new ScreenRecorderUtils(gc, captureSize,
                        new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                                CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                                Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                        null, file, methodName);
                screenRecorder.start();
                LogsUtils.info("Recording started");
            } catch (Exception e) {
                LogsUtils.error("Error starting screen recording: " + e.getMessage());
            }
        }
    }

    public static void stopRecording() {
        try {
            LogsUtils.info("Recording stopped");
            screenRecorder.stop();
        } catch (Exception e) {
            LogsUtils.error("Error stopping screen recording: " + e.getMessage());
        }
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {

        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        return new File(movieFolder,
                name + "-" + TimestampUtils.getTimestamp() + "." + Registry.getInstance().getExtension(fileFormat));
    }
}
