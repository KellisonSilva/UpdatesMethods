package Services;

import java.util.List;
import java.util.function.Predicate;
import Entities.Product;

public class ProductService {

	/**
	 * @param list
	 * @param criteria
	 * @return a soma todos valores seguindo a logica por meio do predicate.
	 * @see Acredito que existe uma codigo melhor que esse, preciso averiguar.
	 */
	public double filteredSum(List<Product> list, Predicate<Product> criteria) {

		double sum = 0.0;
		for (Product p : list) {

			if (criteria.test(p)) {
				sum += p.getPrice();
			}
		}
		return sum;

	}

}
