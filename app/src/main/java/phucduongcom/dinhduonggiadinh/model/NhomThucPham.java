package phucduongcom.dinhduonggiadinh.model;

import android.media.Image;
import android.widget.Button;

import phucduongcom.dinhduonggiadinh.R;

/**
 * Created by phucd on 11/1/2017.
 */

public class NhomThucPham {
    private String Name;
    private int IDimage;

    public NhomThucPham(String name, int IDimage) {
        Name = name;
        this.IDimage = IDimage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIDimage() {
        return IDimage;
    }

    public void setIDimage(int IDimage) {
        this.IDimage = IDimage;
    }
}
