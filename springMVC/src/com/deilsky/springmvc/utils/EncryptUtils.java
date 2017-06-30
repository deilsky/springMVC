package com.deilsky.springmvc.utils;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

public class EncryptUtils {
	public static String encryptBySHA(String data) throws Exception {
		if (StringUtils.isNoneEmpty(data)) {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(data.getBytes());
			byte messageDigest[] = sha.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();
		}
		throw new Error("data and encrypt must not empty !!!");
	}

	public static String encryptByMD5(String data) throws Exception {
		if (StringUtils.isNoneEmpty(data)) {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		}
		throw new Error("data and encrypt must not empty !!!");
	}

	public static String encryptBySHA(String data, String encrypt) throws Exception {
		if (StringUtils.isNoneEmpty(data) && StringUtils.isNoneEmpty(encrypt)) {
			int index = encrypt.length() % 2 > 0 ? encrypt.length() / 2 + 1 : encrypt.length() / 2;
			String key_start = encrypt.substring(0, index);
			String key_end = encrypt.substring(index);
			StringBuffer sb = new StringBuffer(data);
			sb.insert(index, key_start);
			sb.insert(encrypt.length() - index, key_end);
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(sb.toString().getBytes());
			byte messageDigest[] = sha.digest();
			StringBuffer hexString = new StringBuffer("S");
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			String ret = hexString.toString().toUpperCase().substring(0, 32);
			return ret;
		} else {
			throw new Error("data and encrypt must not empty !!!");
		}
	}

	public static String encryptByMD5(String data, String encrypt) throws Exception {
		if (StringUtils.isNoneEmpty(data) && StringUtils.isNoneEmpty(encrypt)) {
			int index = encrypt.length() % 2 > 0 ? encrypt.length() / 2 + 1 : encrypt.length() / 2;
			String key_start = encrypt.substring(0, index);
			String key_end = encrypt.substring(index);
			StringBuffer sb = new StringBuffer(data);
			sb.insert(index, key_start);
			sb.insert(encrypt.length() - index, key_end);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sb.toString().getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("S");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			String ret = buf.toString().toUpperCase().substring(0, 32);
			return ret;
		} else {
			throw new Error("data and encrypt must not empty !!!");
		}
	}
}
