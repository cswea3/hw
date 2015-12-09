package com.craig.androidgames.framework;
/**
 * Created by craig on 12/4/2015.
 */

import com.craig.androidgames.framework.Graphics.PixmapFormat;

public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}
