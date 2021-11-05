package hello.advanced.app.v1;

import org.springframework.stereotype.Service;

import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

	private final OrderRepositoryV1 orderRepository;
	private final HelloTraceV1 trace;

	public void OrderItem(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderServiceV1.OrderItem()");
			orderRepository.save(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
