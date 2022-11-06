package capstone.batch3.loan.user.pojo;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

public class ResponseHeader {
	MultiValueMap<String, String> headers = new HttpHeaders();

	// exposing a custom header for error handling.
	public ResponseHeader() {
		headers.add("Access-Control-Expose-Headers", "success");
	}

	public MultiValueMap<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(MultiValueMap<String, String> headers) {
		this.headers = headers;
	}

	public MultiValueMap<String, String> putOnMap(String key, String value) {
		headers.add(key, value);
		return headers;
	}

}
