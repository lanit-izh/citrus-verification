<#ftl output_format="HTML">

<html>
        <head>
            <title>IncorrectEndpoints</title>

            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
                crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
                crossorigin="anonymous"></script>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
                <script src="https://kit.fontawesome.com/0b83173bdb.js" crossorigin="anonymous"></script>
                <style>
                    .title {
                        margin - top: 60px;
        }

        .progress {
                        position: relative;
        }

        .progress span {
                        position: absolute;
            display: block;
            width: 100%;
            color: black;
        }
    </style>
    </head>
            <body>
                        </div>
                            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                                <div class="container">
                                    <div class="collapse navbar-collapse" id="navbarCollapse">
                                        <ul class="navbar-nav mx-auto">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#headingOne"><h4>GET endpoints</h4></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#headingTwo"><h4>POST endpoints</h4></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#headingThree"><h4>PUT endpoints</h4></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#headingFour"><h4>DELETE endpoints</h4></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-secondary btn-lg btn-block collapsed" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
    <h1> GET INCORRECT ENDPOINTS</h1>
        </button>
      </h5>
    </div>

    <div id="collapseOne" class="collapse show" aria-label="headingOne">
 <ul class="list-group>
                <button type="button" class="list-group-item list-group-item-action"></li>
                <#list results.getGetIncorrectEndpoints() as item>
                <button type="button" class="list-group-item list-group-item-action">${item.getKey()}</li>
                <#else>
                <button type="button" class="list-group-item list-group-item-action"></li>
                <button type="button" class="list-group-item list-group-item-action">All endpoints are correct</li>
            </#list>
</ul>
    </div>
  </div>
      <br>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h5 class="mb-0">
        <button class="btn btn-secondary btn-lg btn-block collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
           <h1>POST INCORRECT ENDPOINTS</h1>
        </button>
      </h5>
    </div>
    <div id="collapseTwo" class="collapse show" aria-label="headingTwo">
 <ul class="list-group>
                 <button type="button" class="list-group-item list-group-item-action"></li>
                <#list results.getPostIncorrectEndpoints() as key>
                <button type="button" class="list-group-item list-group-item-action">${key.getKey()}</li>
                <#else>
              <button type="button" class="list-group-item list-group-item-action">All endpoints are correct</li>

            </#list>
</ul>
    </div>
  </div>
    <div class="card">
      <div class="card-header" id="headingThree">
        <h5 class="mb-0">
          <button class="btn btn-secondary btn-lg btn-block collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
             <h1>PUT INCORRECT ENDPOINTS</h1>
          </button>
        </h5>
      </div>
      <div id="collapseThree" class="collapse show" aria-label="headingThree">
   <ul class="list-group>
                   <button type="button" class="list-group-item list-group-item-action"></li>
                  <#list results.getPutIncorrectEndpoints() as key>
                  <button type="button" class="list-group-item list-group-item-action">${key.getKey()}</li>
                  <#else>
                   <button type="button" class="list-group-item list-group-item-action">All endpoints are correct</li>

              </#list>
  </ul>
      </div>
    </div>
    <div class="card">
      <div class="card-header" id="headingFour">
        <h5 class="mb-0">
          <button class="btn btn-secondary btn-lg btn-block collapsed" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
             <h1>DELETE INCORRECT ENDPOINTS</h1>
          </button>
        </h5>
      </div>
      <div id="collapseFour" class="collapse show" aria-label="headingFour">
   <ul class="list-group>
                   <button type="button" class="list-group-item list-group-item-action"></li>
                  <#list results.getDeleteIncorrectEndpoints() as key>
                  <button type="button" class="list-group-item list-group-item-action">${key.getKey()}</li>
                  <#else>
                         <button type="button" class="list-group-item list-group-item-action">All endpoints are correct</li>
              </#list>
  </ul>
      </div>
    </div>
</body>
</html>