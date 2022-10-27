$(function(){
    
    loadGenreTable(function(response){
        console.log("main.js")
        $('#tableRender').html(response)
    })

})

