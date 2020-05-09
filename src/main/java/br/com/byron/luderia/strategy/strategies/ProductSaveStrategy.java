package br.com.byron.luderia.strategy.strategies;

import br.com.byron.luderia.model.Product;
import br.com.byron.luderia.repository.IImageRepository;
import br.com.byron.luderia.strategy.IStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class ProductSaveStrategy implements IStrategy<Product> {

	private final IImageRepository imageRepository;

	@Override
	public void execute(Product product) {
		if (product.getImage() != null && !StringUtils.isEmpty(product.getImage().getFile())) {
			product.setImage(imageRepository.save(product.getImage()));

			product.getImage().setFile(product.getImage().getFile().split(":")[1]);

			String[] preFilter = product.getImage().getFile().split(",");
			String[] barrerFilter = preFilter[0].split(";");

			product.getImage().setType(barrerFilter[0]);

			byte[] image = Base64.getDecoder().decode(preFilter[1]);

			product.getImage().setSize(image.length);

			String path = "c:/images/" + product.getImage().getId() + "." + barrerFilter[0].split("/")[1];

			product.getImage().setPath(path);

			try {
				FileOutputStream fos = new FileOutputStream(new File(path));
				fos.write(image);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
