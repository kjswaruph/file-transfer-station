package com.swaruph.web.dao;

import com.swaruph.web.model.FileTransfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FileTransferDao {
    public FileTransfer getFile(int fid){
        FileTransfer fileTransfer = new FileTransfer();

        try {
            String url = "jdbc:mysql://localhost:3306/file_sync";
            String username = "sonic";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from file_sync.files where fid="+fid);
            if(rs.next()){
                fileTransfer.setFid(rs.getInt("fid"));
                fileTransfer.setFileName(rs.getString("file_name"));
                fileTransfer.setPath(rs.getString("file_path"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return fileTransfer;
    }
}
