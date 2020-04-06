## Example of JPA Repository returning Stream 

Stream will provide results immediately as opposed to a Collection which Service won't be able to process until whole collection is filled 
and returned by Repository. \
Key notes:
* Calling method has to be annotated @Transactional(readOnly = true)
* Repository method needs @QueryHints 
