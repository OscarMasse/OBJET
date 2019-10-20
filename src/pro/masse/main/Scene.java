package pro.masse.main;

import java.util.LinkedList;
import java.util.List;

public class Scene {

    private List<Entity> entities;
    private List<Renderable> renderables;

    public Scene(){
        entities = new LinkedList<>();
        renderables = new LinkedList<>();
    }

    public void update() {
        for (Entity entity :
                entities) {
            entity.update();
        }
    }

    public void render(Graphics2D graphics2D) {
        for (Renderable renderable :
                renderables) {
            renderable.render(graphics2D);
        }
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
        this.renderables.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
        this.renderables.remove(entity);
    }
}
