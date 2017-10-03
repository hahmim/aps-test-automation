package com.aps.testing.cucumber.stepDefinitions;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class XMLToDbVerificationHelper {

	/**
	 * establishes connection to the cloud server 
	 * and drops the file in a sub-directory
	 * @param user
	 * @param host
	 * @param privateKey
	 * @param fileName
	 * @return
	 */
	public String runShell(String user, String host, String privateKey,String fileName){
		String outcome = "";
		try {
			/**
			 * adding the attributes to jsch to establish connection
			 */
			JSch jsch = new JSch();
			int port = 22;

			jsch.addIdentity(privateKey);
			JSch.setConfig("StrictHostKeyChecking", "no");

			Session session = jsch.getSession(user, host, port);

			session.connect();

			/**
			 * creates an sftp session to transfer the file to the root dir
			 */
			Channel channel1 = session.openChannel("sftp");
			channel1.setInputStream(System.in);
			channel1.setOutputStream(System.out);
			channel1.connect();

			ChannelSftp c = (ChannelSftp) channel1;

			c.put(fileName, ".");
			c.exit();
			channel1.disconnect();

			/**
			 * creates an ssh session to run shell commands on the remote server
			 */
			Channel channel = session.openChannel("shell");
			System.out.println("shell channel connected....");
			OutputStream ops = channel.getOutputStream();
			PrintStream ps = new PrintStream(ops, true);
			String command0 = "sudo su - ec2-user";
			String command1 = "sudo mv " + fileName + " /tmp/nifi";
			String command2 = "sudo chown nifi:nifi /tmp/nifi/" + fileName;
			String command3 = "sudo su - nifi ";
			String conditionalComannd = "if \n"
										+ "[ ! -f /tmp/nifi/"+fileName+ " ] \n " 
										+ "then \n "+
										command1+ " && "+command2+" && "+command3+" \n"+
										" else \n"
										+"sudo rm "+fileName+" && echo 'file removed' \n"+
										" fi"; 


			channel.connect();
			ps.println(command0);
			ps.println(conditionalComannd);
//			ps.println(command2);
//			ps.println(command3);
			InputStream in = channel.getInputStream();
			byte[] tmp = new byte[1024];

			while(true){
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						channel.disconnect();
					System.out.print(new String(tmp, 0, i));
				}

				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					// the loop needs to break out to print
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ee) {
			}
			outcome = "File Transfered";

			channel.disconnect();
			session.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return outcome;
	}



}
