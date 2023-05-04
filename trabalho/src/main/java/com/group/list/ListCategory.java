package com.group.list;

import com.group.entities.Category;
import com.group.lde.LdeCategory;
import com.group.lde.Node;

public class ListCategory {
    
    private LdeCategory ldeCategory;

    public ListCategory() {
        this.ldeCategory = new LdeCategory();
    }

    public ListCategory(LdeCategory ldeCategory) {
        this.ldeCategory = ldeCategory;
    }

    public void addCategoryAtBeginning(Category category) {
        if(category == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeCategory.insertAtBeginning(category);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addCategoryAtEnd(Category category) {
        if(category == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            this.ldeCategory.insertAtEnd(category);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean removeCategory(long id) {
        if(id <= 0) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        try {
            return this.ldeCategory.remove(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Node find(long id) {
        if(id < 0) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        return this.ldeCategory.find(id);        
    }

    public boolean existe(long id) {
        if(id < 0) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        Node node = this.ldeCategory.find(id);

        return node != null;
    }

    public int size() {
        return this.ldeCategory.size();
    }

    public boolean isEmpty() {
        return this.ldeCategory.isEmpty();
    }
   
    public String getListFromBeginning() {
       return this.ldeCategory.getListFromBeginning();
    }

    public String getListFromEnd() {
        return this.ldeCategory.getListFromEnd();
    }

    public void setName(Category category, String name) {
        if(category == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }

        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException("O nome não pode ser nulo");
        }

        category.setName(name);
    }

    public void setId(Category category, long id) {
        if(category == null) {
            throw new NullPointerException("O objeto informado é nulo");
        }
        
        category.setId(id);
    }
}
