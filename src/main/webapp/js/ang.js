var app = angular.module('myApp', []);


app.controller('MyCtrl',function ($scope, $http, $rootScope) {

    $scope.get_categories = function () {
        $http.get("/categories").success(function (data) {
            $scope.categories = data;
            console.log(data);
        })
    };

    $rootScope.message = 'Messaaaaggee';

    $scope.find_by_category = function (c) {
        $scope.items = null;
        $http.get("/find_by_category/" + c.id).success(function (data) {
            $scope.items = data;
        });
        console.log(c.id);
    };

    $scope.reset_category_filter = function () {
        $scope.items = null;
        $scope.get_items();

    };

    $scope.uploadFormDataUsingAjax = function (){
        var uploadForm = new FormData();
        uploadForm.append("file", image.files[0]);
        uploadForm.append("name", document.getElementById('name').value);
        uploadForm.append("nameOfPic", document.getElementById('image').files[0].name);
        uploadForm.append("price", document.getElementById('price').value);
        uploadForm.append("category", document.getElementById('category').value);

        $.ajax({
            url: 'http://localhost/add_item',
            data: uploadForm,
            dataType: 'text',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function(data){
                $scope.items[$scope.items.length] = data;
            }
        });

        console.log(document.getElementById('image').files[0].name);
       // console.log(document.getElementById('photo').getAttribute('src'));
    };

    $scope.submit_new_user = function () {

        var fd = new FormData();

        fd.append("username", document.getElementById("new_name").value);
        fd.append("password", document.getElementById("new_password").value);

        $http.post("/register_user", fd,{
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .success(function(data){
                console.log(data);
            })
            .error(function(){
            });

    };



    // $scope.test = function () {
    //     var item = {
    //         name: document.getElementById('name').value,
    //         price: document.getElementById('price').value,
    //         category: document.getElementById('category').value,
    //         photo: document.querySelector('input[type=file]').files[0]
    // };
    //
    //     console.log(item);
    // };

    $scope.get_items = function () {
        $http.get("/items").success(function (data) {
            $scope.items = data;
            console.log(data);
        })
    };

});



function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#photo').remove();
            $('.img_edit').html('<img id="photo" src="'+e.target.result+'" style="width: 140px;" class="img-rounded" alt="Cinque Terre" height="auto">')
        };
        reader.readAsDataURL(input.files[0]);

    }

}