package com.workintech.library.domain;

public enum Category {
    FICTION,
    HISTORY,
    SCIENCE,
    TECHNOLOGY,
    ART,
    PHILOSOPHY;

    // Bir instance oluşturmadan kullanabilmek için bu func'ları static tanımladık
    public static void printCategories(){
        for(int i = 0; i < Category.values().length; i++){
            System.out.println((i+ 1) + "-" + Category.values()[i]);
        }
    }
    public static Category getCategory(int index){
        if(index < Category.values().length){

        }
        return Category.values()[index-1];
    }
}
