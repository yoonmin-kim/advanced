package hello.advanced.app.v5;

import org.springframework.stereotype.Service;

import hello.advanced.app.trace.callback.TraceTemplate;
import hello.advanced.app.trace.logtrace.LogTrace;

@Service
public class OrderServiceV5 {

	private final OrderRepositoryV5 orderRepository;
	private final TraceTemplate template;

	public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
		this.orderRepository = orderRepository;
		this.template = new TraceTemplate(trace);
	}

	public void OrderItem(String itemId) {
		template.execute("OrderServiceV5.OrderItem()", () -> {
			orderRepository.save(itemId);
			return null;
		});
	}
}
