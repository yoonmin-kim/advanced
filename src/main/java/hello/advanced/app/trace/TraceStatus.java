package hello.advanced.app.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TraceStatus {

	private TraceId traceId;
	private Long startTimeMs;
	private String message;
}
