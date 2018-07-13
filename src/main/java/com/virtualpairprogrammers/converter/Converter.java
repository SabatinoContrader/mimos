package com.virtualpairprogrammers.converter;

interface Converter<Entity, DTO> {

    public Entity convertToEntity(DTO dto);

    public DTO convertToDTO(Entity entity);
}
