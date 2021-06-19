package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import  kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;


@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	
	
	@Override
	public DataResult <List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<Product>>(this.productDao.findAll(),"data listelendi");
		
	}



	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessDataResult<Object> ("ürün eklendi");
	}



	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <Product>(this.productDao.getByProductName(productName),"data listelendi");
	}



	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<Product>>(this.productDao.getByCategoryIn(categories),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<Product>>(this.productDao.getByProductNameContains(productName),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<Product>>(this.productDao.getByProductNameStartsWith(productName),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult <List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"data listelendi");
	}



	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent());
	}



	@Override
	public DataResult<List<Product>> getAllSorted() {
		// TODO Auto-generated method stub
		Sort sort =Sort.by(Sort.Direction.DESC);
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"başarılı");
	}



	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		 return new SuccessDataResult <List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"data listelendi");
	}

}
