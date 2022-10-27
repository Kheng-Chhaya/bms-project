$('.btn-delete').on('click',function(){
    let id = $(this).data('id')
    console.log("listener")
    let href = $('#btnConfirm').attr('href')
    $('#btnConfirm').attr('href',href+id)
})