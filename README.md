# Publicaciones y Comentasrios

APIs REST en Spring Boot con JWT , Spring Security , MySQL y Spring Data JPA

-------------------------------

## Tecnologias:

-JAVA v11

-JWT

-MySQL

-Spring Data JPA

-------------------------------

## Información:

Endpoints:

##Publicación:

*GET
api/publicaciones/{id}
(Permite obtener una publicación mediante su ID)

*POST
api/publicaciones
(Permite crear una nueva publicación)

*PUT
/api/publicaciones/{id}
(Permite actualizar una publicación mediante su ID)

*DELETE
/api/publicaciones/{id}
(Elimina una publicación mediante su ID)

##Comentario:

*GET
api/publicaciones/{publicacionId}/comentarios
(Obtiene una publicación por su ID con sus comentarios)

*GET
api/publicaciones/{publicacionId}/comentarios/{comentarioId}
(Obtiene un comentario a partir de ID publicacones + ID comentario)

*POST
api/publicaciones/{publicacionId}/comentarios
(Crea un comentario en una publicación desde su ID)

*PUT
api/publicaciones/{publicacionId}/comentarios/{comentarioId}
(Permite editar un comentario desde ID publicación + ID comentario)

*DELETE
api/publicaciones/{publicacionId}/comentarios/{comentarioId}
(Permite eliminar un comentario desde ID publicación + ID comentario)
