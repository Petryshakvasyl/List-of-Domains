function deleteDomain(id) {
  str = 'deleteDomain/' + id;
  $.ajax({
         url: str,
         success: function(){
            alert("You have successfully deleted the domain's name");
            location.reload();
         }
  });
}

function updateDomain(id) {
 str = 'getNameDomain/' + id;
  $.ajax({
         url: str,
         success: function(name){
           $("#modal-input").val(name);
           $('#updatingDomain').modal('show');
           str = 'updateDomains/' + id;
           $("#button-update").on("click", function(){
                var updatedName = $("#modal-input").val();
                str = "updateDomainName/" + updatedName + "/" + id;
                $.ajax({
                    url: str,
                    success: function(){
                        alert("You have successfully updated the domain's name from " + name + " to " + updatedName);
                        location.reload();
                    }
                });
           });
         }
  });
}