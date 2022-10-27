const loadGenreTable = (callback) => {
    fetch(`/tmp/genre/table`,{
        method: 'GET'
    })
    .then(response => response.text())
    .then(response => {
        if(typeof callback == 'function')
        {
            
        
            callback(response)
            
        }
    })

 
}

const fetchDeleteModel = (callback) => {
    fetch(`/tmp/genre/modal`,{
        method: 'GET'
    })
    .then(response => response.text())
    .then(response => {
        if(typeof callback == 'function')
        {
            
            
            callback(response)
            
        }
    })

 
}




