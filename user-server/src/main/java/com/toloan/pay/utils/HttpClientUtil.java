package com.toloan.pay.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;

import static com.alibaba.druid.util.Utils.md5;


@SuppressWarnings("deprecation")
public class HttpClientUtil {

	private static final String charset = "utf-8";

	public static String get(String reqURL, Map<String, Object> params) {
		String queryString = "";
		if (!StringUtils.contains(reqURL, "?")) {
			queryString += "?";
		}
		for (Entry<String, Object> entry : params.entrySet()) {
			queryString += ("&" + entry.getKey()) + "="
					+ (String.valueOf(entry.getValue()));
		}
		queryString = queryString.replace("?&", "?");
		return get(reqURL + queryString);
	}

	public static byte[] getStream(String reqURL) {
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			HttpGet httpGet = new HttpGet(reqURL); // 创建org.apache.http.client.methods.HttpGet
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000).build();
			httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity(); // 获取响应实体
				byte in2b[] = instreamToByte(entity.getContent());
				return in2b;
			} catch (IOException e) {
			} finally {
				response.close();
			}
		} catch (IOException e1) {
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	private static byte[] instreamToByte(InputStream input) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[4096];
		int n = 0;
		while (-1 != (n = input.read(buff))) {
			swapStream.write(buff, 0, n);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}

	public static String get(String reqURL) {
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			HttpGet httpGet = new HttpGet(reqURL); // 创建org.apache.http.client.methods.HttpGet
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(5000).setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000).build();
			httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				HttpEntity entity = response.getEntity(); // 获取响应实体
				Charset respCharset = ContentType.getOrDefault(entity)
						.withCharset(charset).getCharset();
				return EntityUtils.toString(entity, respCharset);
			} catch (IOException e) {
			} finally {
				response.close();
			}
		} catch (IOException e1) {
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	public static String postJson(String reqURL, Object param) {
		SSLConnectionSocketFactory sslsf = null;
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
					null, new TrustStrategy() {
						// 信任所有
						public boolean isTrusted(X509Certificate[] chain,
												 String authType) throws CertificateException {
							return true;
						}
					}).build();
			sslsf = new SSLConnectionSocketFactory(sslContext);
		} catch (KeyManagementException e) {
			return null;
		} catch (NoSuchAlgorithmException e) {
			return null;
		} catch (KeyStoreException e) {
			return null;
		}
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		try {
			RequestBuilder builder = RequestBuilder.post(reqURL);
			if (param != null) {
				StringEntity stringEntity = new StringEntity(JSON.toJSONString(param), charset);
				builder.setEntity(stringEntity);
			}
			HttpUriRequest post = builder.build();
			CloseableHttpResponse response = httpclient.execute(post);
			try {
				return getString(response);
			} finally {
				response.close();
			}
		} catch (IOException e) {
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	public static String postForm(String reqURL, Map<String, Object> params) {
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			RequestBuilder builder = RequestBuilder.post(reqURL);
			builder.setCharset(Charset.forName(charset));
			MultipartEntity httpEntity = new MultipartEntity();
			if (params != null) {
				for (Entry<String, Object> entry : params.entrySet()) {
					FormBodyPart formBodyPart = new FormBodyPart(
							entry.getKey(), new StringBody(String.valueOf(entry
							.getValue()), "text/plain",
							Charset.forName(charset)));
					httpEntity.addPart(formBodyPart);
				}
			}
			builder.setEntity(httpEntity);
			HttpUriRequest post = builder.build();
			CloseableHttpResponse response = httpclient.execute(post);
			try {
				return getString(response);
			} finally {
				response.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	private static String getString(CloseableHttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		Charset respCharset = ContentType.getOrDefault(entity)
                .withCharset(charset).getCharset();
		String result = EntityUtils.toString(entity, respCharset);
		EntityUtils.consume(entity);
		return result;
	}
}
