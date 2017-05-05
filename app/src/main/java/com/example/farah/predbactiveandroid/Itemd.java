package com.example.farah.predbactiveandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by farah on 4/29/2017.
 */
@Table(name = "vocf",id = "id")
public class Itemd extends Model implements Serializable {

    //The table consist only one field name

    @Column(name = "id")
    public String idn;
    @Column(name = "namef")
    public String namef;
    @Column(name = "imgvoc")
    public byte[] imgvoc;

}
