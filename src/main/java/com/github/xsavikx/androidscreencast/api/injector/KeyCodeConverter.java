package com.github.xsavikx.androidscreencast.api.injector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.KeyEvent;

public class KeyCodeConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(KeyCodeConverter.class);

    public static int getKeyCode(KeyEvent e) {
        LOGGER.debug("getKeyCode(KeyEvent e={}) - start", e);
        int code = InputKeyEvent.KEYCODE_UNKNOWN.getCode();
        char c = e.getKeyChar();
        int keyCode = e.getKeyCode();
        InputKeyEvent inputKeyEvent = InputKeyEvent.getByCharacterOrKeyCode(Character.toLowerCase(c), keyCode);
        if (inputKeyEvent != null) {
            code = inputKeyEvent.getCode();
        }
        LOGGER.debug("Received KeyEvent={}. Produced KeyCode={}", String.valueOf(e), code);
        return code;
    }

}
