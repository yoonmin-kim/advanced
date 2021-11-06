package hello.advanced.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

	private final OrderServiceV3 orderService;
	private final LogTrace trace;

	@GetMapping("/v3/request")
	public String request(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderControllerV3.request()");
			orderService.OrderItem(itemId);
			trace.end(status);
			return "ok";
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
