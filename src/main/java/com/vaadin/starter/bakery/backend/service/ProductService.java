package com.vaadin.starter.bakery.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.vaadin.starter.bakery.backend.data.entity.Product;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.ProductRepository;

@Service
public class ProductService implements FilterableCrudService<Product> {
	/**
	 * Repository for Product entity operations.
	 */
	private final ProductRepository productRepository;

	/**
	 * Constructs a new ProductService with the specified repository.
	 *
	 * @param productRepository the repository to handle Product entity operations
	 */
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Finds products matching an optional filter string.
	 *
	 * @param filter   optional string to filter products by name (case-insensitive)
	 * @param pageable pagination information
	 * @return a Page of Products matching the filter criteria
	 */
	@Override
	public Page<Product> findAnyMatching(Optional<String> filter, Pageable pageable) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return productRepository.findByNameLikeIgnoreCase(repositoryFilter, pageable);
		} else {
			return find(pageable);
		}
	}

	/**
	 * Counts the number of products matching an optional filter string.
	 *
	 * @param filter optional string to filter products by name (case-insensitive)
	 * @return the number of products matching the filter criteria
	 */
	@Override
	public long countAnyMatching(Optional<String> filter) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return productRepository.countByNameLikeIgnoreCase(repositoryFilter);
		} else {
			return count();
		}
	}

	/**
	 * Retrieves a page of products.
	 *
	 * @param pageable pagination information
	 * @return a Page of Products
	 */
	public Page<Product> find(Pageable pageable) {
		return productRepository.findBy(pageable);
	}

	/**
	 * Gets the JPA repository for Product entities.
	 *
	 * @return the product repository
	 */
	@Override
	public JpaRepository<Product, Long> getRepository() {
		return productRepository;
	}

	/**
	 * Creates a new Product instance.
	 *
	 * @param currentUser the user creating the product
	 * @return a new Product instance
	 */
	@Override
	public Product createNew(User currentUser) {
		return new Product();
	}

	/**
	 * Saves a product entity. Throws an exception if a product with the same name already exists.
	 *
	 * @param currentUser the user saving the product
	 * @param entity     the product to save
	 * @return the saved product
	 * @throws UserFriendlyDataException if a product with the same name already exists
	 */
	@Override
	public Product save(User currentUser, Product entity) {
		try {
			return FilterableCrudService.super.save(currentUser, entity);
		} catch (DataIntegrityViolationException e) {
			throw new UserFriendlyDataException(
					"There is already a product with that name. Please select a unique name for the product.");
		}

	}

}
