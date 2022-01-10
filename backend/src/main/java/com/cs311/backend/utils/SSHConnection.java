package com.cs311.backend.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SSHConnection {

    private final static int LOCAl_PORT = 3307;

    private final static String SSH_REMOTE_SERVER = "sql.cs.oberlin.edu";
    private final static int SSH_REMOTE_PORT = 22;
    private final static String SSH_USER = "rhuang";
    private final static String SSH_PASSWORD = "REDevil7";

    private final static String MYSQL_REMOTE_SERVER = "127.0.0.1";
    private final static int REMOTE_PORT = 3306;

    private final Session session; //represents each ssh session

    public void closeSSH ()
    {
        session.disconnect();
    }

    public SSHConnection () throws Throwable
    {

        JSch jsch = new JSch();
        session = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);

        session.setPassword(SSH_PASSWORD);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect(); //ssh connection established!

        //by security policy, you must connect through a fowarded port
        session.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);

    }
}