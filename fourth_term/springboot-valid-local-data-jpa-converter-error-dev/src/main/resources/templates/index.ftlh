<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link type="text/css" rel="stylesheet" href="<@spring.url "/css/style.css"/>"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">


    <title><@spring.message 'index.title'/></title>
</head>
<body>

    <div class="header">
        <div class="header-item">
            <a href="?lang=ru">РУ</a>
        </div>
        <div class="header-item">
            <a href="?lang=en">EN</a>
        </div>
    </div>

    <@spring.bind "postForm"/>
    <form action="<@spring.url "/posts"/>" method="POST">
    <div class="container mt-4 mb-4">
        <div class="row justify-content-md-center">
            <div class="col-md-12 col-lg-8">
                <h1 class="h2 mb-4"><@spring.message 'index.post_form.main.title'/></h1>
                <label><@spring.message 'index.post_form.title'/></label>
                <div>
<#--                    <@spring.formInput "postForm.title" "class=\"form-control mb-2\""/>-->
                    <input type="text" name="title" class="form-control mb-2" style="width:100%"  placeholder="<@spring.message 'index.post_form.title.placeholder'/>" value=""/>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <label><@spring.message 'index.post_form.text'/></label>
                <div>
<#--                    <@spring.formInput "postForm.text" "class=\"form-control mb-2\""/>-->
                    <input type="text" name="text" class="form-control mb-2" style="width:100%"  placeholder="<@spring.message 'index.post_form.text.placeholder'/>" value=""/>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <label><@spring.message 'index.post_form.category'/></label>
                <div>
<#--                    <@spring.formMultiSelect "path = postForm.category"-->
                    <select name="categoryName" class="form-control mb-2" style="width:100%" >
                        <option selected="selected" class="m-2" value="movies"><@spring.message 'index.post_form.category.movies'/></option>
                        <option class="m-2" value="medicine"><@spring.message 'index.post_form.category.medicine'/></option>
                        <option class="m-2" value="sport"><@spring.message 'index.post_form.category.sport'/></option>
                    </select>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <button type="submit" class="btn btn-primary"><@spring.message 'index.post_form.save_post'/></button>
            </div>
        </div>
    </div>
    </form>

</body>
</html>