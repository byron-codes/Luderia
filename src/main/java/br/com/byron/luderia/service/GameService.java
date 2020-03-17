package br.com.byron.luderia.service;

import java.io.*;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.luderia.dto.filter.GameFilter;
import br.com.byron.luderia.model.Game;
import br.com.byron.luderia.repository.IGameRepository;
import br.com.byron.luderia.repository.specification.GameSpecification;

@Service
public class GameService extends GenericService<Game, GameFilter> {

    private IGameRepository repository;

    GameService(IGameRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Game> find(GameFilter filter) {
        return repository.findAll(new GameSpecification(filter));
    }

    @Override
    public Game add(Game entity) {
        Game game = super.add(entity);
        if (!game.getImage().getFile().isEmpty()) {
            game.getImage().setFile(entity.getImage().getFile().split(":")[1]);

            String[] preFilter = entity.getImage().getFile().split(",");
            String[] barrerFilter = preFilter[0].split(";");

            game.getImage().setType(barrerFilter[0]);

            byte[] image = Base64.getDecoder().decode(preFilter[1]);

            game.getImage().setSize(image.length);

            String path = "c:/images/" + game.getImage().getId() + "." + barrerFilter[0].split("/")[1];

            game.getImage().setPath(path);

            try {
                FileOutputStream fos = new FileOutputStream(new File(path));
                fos.write(image);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.update(game);
        }
        return game;
    }
}
