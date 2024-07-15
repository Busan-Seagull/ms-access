package com.ryan.ms_access.config;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import net.ucanaccess.jdbc.JackcessOpenerInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

public class CodecOpener implements JackcessOpenerInterface {

    private String password;
    @Autowired
    public CodecOpener(String password){
        this.password = password;
    }

    @Override
    public Database open(File fl, String pwd) throws IOException {
        Database db = new DatabaseBuilder(fl).setCodecProvider(new CryptCodecProvider(this.password)).open();
        return db;
    }
}
