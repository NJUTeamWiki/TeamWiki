package cn.edu.nju.teamwiki.util;

import org.jodconverter.JodConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author: xuyangchen
 * @date: 2020/3/21
 */
public class OfficeUtils {

    private static final Logger LOG = LoggerFactory.getLogger(OfficeUtils.class);

    private static final OfficeManager MANAGER = LocalOfficeManager.install();

    static {
        try {
            MANAGER.start();
        } catch (OfficeException e) {
            LOG.error("OfficeManager failed to start, due to:", e);
        }
    }

    public static void convert(File inputFile, File outputFile) throws OfficeException {
        JodConverter.convert(inputFile).to(outputFile).execute();
    }

    public static void onExit() {
        try {
            MANAGER.stop();
        } catch (OfficeException e) {
            LOG.error("OfficeManager failed to stop, due to:", e);
        }
    }

}
