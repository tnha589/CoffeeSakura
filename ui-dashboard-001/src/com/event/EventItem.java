package com.event;

import com.model.SanPham;
import java.awt.Component;

public interface EventItem {

    public void itemClick(Component com, SanPham item);
}
