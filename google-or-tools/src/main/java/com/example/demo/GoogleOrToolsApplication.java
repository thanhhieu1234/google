package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GoogleOrToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleOrToolsApplication.class, args);
	}

	private static final Logger logger = java.util.logging.Logger.getLogger(GoogleOrToolsApplication.class.getName());

	@Bean
	public static String test() {

		// ---------------------------------
		long start = System.currentTimeMillis();

		List<Route> routes = new ArrayList<>();
		routes.add(new Route(30000, 200, 200));
		routes.add(new Route(30000, 2300, 10));
		routes.add(new Route(300, 400000, 500));
		routes.add(new Route(500, 0, 0));
		routes.add(new Route(10, 46000, 4000));
		routes.add(new Route(5, 46000, 4000));
		routes.add(new Route(1, 40, 4000));

		List<Integer> minPath = null;
		int minCost = Integer.MAX_VALUE;

		int n = routes.size();
		System.out.println("size" + n);
		// Duyệt qua tất cả các tổ hợp của tuyến NVC A
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// for (int k = j + 1; k < n; k++) {
				for (int l = 0; l < n; l++) {
					for (int m = 0; m < n; m++) {
						if (l != m) { // Kiểm tra tuyến NVC B và NVC C không trùng nhau
							int costA1 = routes.get(i).costA;
							int costA2 = routes.get(j).costA;
							// int costA3 = routes.get(k).costA;
							int costB = routes.get(l).costB;
							int costC = routes.get(m).costC;
							int totalCost = costA1 + costA2 + costB + costC;

							// Kiểm tra xem tổng chi phí có là tối ưu nhất không
							if (totalCost < minCost) {
								minCost = totalCost;
								minPath = new ArrayList<>();
								minPath.add(i + 1); // Tuyến NVC A
								minPath.add(j + 1); // Tuyến NVC A
								// minPath.add(k + 1); // Tuyến NVC A
								minPath.add(l + 1); // Tuyến NVC B
								minPath.add(m + 1); // Tuyến NVC C
							}
						}
						// }
					}
				}
			}
		}

		long end = System.currentTimeMillis();
		logger.info((end - start) + "ms");
		logger.info("Gia thap nhat " + minCost);
		logger.info("Tuyen duong " + minPath);

		return "";
	}

}
