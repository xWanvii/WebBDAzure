package co.edu.poli.examen2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.poli.examen2.model.Producto;
import co.edu.poli.examen2.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
	private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();   
        
    }

    public Producto getProductoById(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(String id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setDescripcion(producto.getDescripcion());
            return productoRepository.save(existingProducto);
        }
        return null; 
    }

    public Producto deleteProducto(String id) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            productoRepository.delete(existingProducto);
            return existingProducto;
        }
        return null;
    }
    
}
