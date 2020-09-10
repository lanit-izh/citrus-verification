<#ftl output_format="HTML">
    <#import "generation.ftl" as generation />

<html>
        <head>
            <title>IncorrectEndpoints</title>
script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
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
            <h1>GET INCORRECT ENDPOINTS</h1>
            <ul>
                <#list results.getGetIncorrectEndpoints() as item>
                <li>${item.getKey()}</li>
                <#else>
                    <p>All endpoints are correct
            </#list>
</ul>
                <h1>POST INCORRECT ENDPOINTS</h1>
                <nav role="navigation">
                    <ul>
                        <#list results.getPostIncorrectEndpoints() as item>
           <li>${item.getKey()}</li>
                        <#else>
                            <p>All endpoints are correct
       </#list>
   </ul>
</nav>
                    <h1>PUT INCORRECT ENDPOINTS</h1>
                    <ul>
                        <#list results.getPutIncorrectEndpoints() as item>
           <li>${item.getKey()}</li>
                        <#else>
                            <p>All endpoints are correct
       </#list>
   </ul>

                        <h1>DELETE INCORRECT ENDPOINTS</h1>
                        <ul>
                            <#list results.getDeleteIncorrectEndpoints() as item>
              <li>${item.getKey()}</li>
                            <#else>
                                <p>All endpoints are correct
          </#list>
      </ul>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                </li>
                </li>
                <li class="nav-item">
                </li>
                <li class="nav-item">
                </li>
                <li class="nav-item">
                </li>
            </ul>
        </div>
    </div>
</nav>

<main role="main" class="container">
    <div class="container">
        <section id="summary-section">
            <div class="row">
                <div class="col-12">
                </div>
            </div>
        </section>

        <section id="details-section">
            <div class="row">
                <div class="col-12">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <ul class="nav nav-pills nav-fill" id="detail-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="condition-tab" data-toggle="tab" href="#condition" role="tab"
                               aria-controls="condition" aria-selected="true">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="full-tab" data-toggle="tab" href="#full" role="tab"
                               aria-controls="full" aria-selected="true">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="party-tab" data-toggle="tab" href="#party" role="tab"
                               aria-controls="party" aria-selected="true">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="empty-tab" data-toggle="tab" href="#empty" role="tab"
                               aria-controls="empty" aria-selected="true">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="zero-tab" data-toggle="tab" href="#zero" role="tab"
                               aria-controls="zero" aria-selected="true">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="missed-tab" data-toggle="tab" href="#missed" role="tab"
                               aria-controls="missed" aria-selected="false">
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-12">
                    <div class="tab-content" id="details-content">
                        <div class="tab-pane fade show active" id="condition" role="tabpanel" aria-labelledby="condition-tab">
                        </div>
                        <div class="tab-pane fade" id="full" role="tabpanel" aria-labelledby="full-tab">
                        </div>
                        <div class="tab-pane fade" id="party" role="tabpanel" aria-labelledby="party-tab">
                        </div>
                        <div class="tab-pane fade" id="empty" role="tabpanel" aria-labelledby="empty-tab">
                        </div>
                        <div class="tab-pane fade" id="zero" role="tabpanel" aria-labelledby="zero-tab">
                        </div>
                        <div class="tab-pane fade" id="missed" role="tabpanel" aria-labelledby="missed-tab">
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section id="tag-section">
            <div class="row">
                <div class="col-12">
                </div>
            </div>
        </section>

        <section id="condition-section">
            <div class="row">
                <div class="col-12">
                </div>
            </div>
            <div class="row">
                <div class="accordion col-12" id="conditions-by-type-accordion">
                        <div class="card">
                            <div class="card-header">
                                <div class="row"
                                     data-toggle="collapse"
                                     aria-expanded="true"
                                     aria-controls="collapseOne">
                                    <div class="col-8">
                                        <small>descriptionKey</small>
                                    </div>
                                    <div class="col-4">
                                    </div>
                                </div>
                            </div>
                            <div id="conditions-by-type" class="collapse" aria-labelledby="headingOne">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <ul class="nav nav-pills nav-fill" id="condition-tabs" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" id="tab-condition-covered" data-toggle="tab" href="#condition-covered" role="tab"
                                                       aria-controls="condition-covered" aria-selected="true">
                                                                                                        </a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" id="tab-condition-uncovered" data-toggle="tab" href="#condition-uncovered-" role="tab"
                                                       aria-controls="condition-uncovered" aria-selected="true">
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="tab-content" id="details-content">
                                                <div class="tab-pane fade show active" id="condition-covered" role="tabpanel" aria-labelledby="tab-condition-covered-">
                                                    <table class="table table-sm">
                                                        <thead>
                                                        <tr>
                                                            <th scope="col"></th>
                                                            <th scope="col"></th>
                                                            <th scope="col"></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="tab-pane fade" id="condition-uncovered" role="tabpanel" aria-labelledby="tab-condition-uncovered">
                                                    <table class="table table-sm">
                                                        <thead>
                                                        <tr>
                                                            <th scope="col"></th>
                                                            <th scope="col">e</th>
                                                            <th scope="col"></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <div>
                                                            <tr class="table-danger">
                                                                <td>
                                                                    <span>
                                                                        <i class="fas fa-bug"></i>
                                                                    </span>

                                                                </td>
                                                                <td></td>
                                                                <td>$</td>
                                                            </tr>
                                                        </div>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        </section>

        <section id="system-section">
            <div class="row">
                <div class="col-12">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="col-sm">
                        <div class="alert alert-secondary" role="alert">
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer class="page-footer font-small mdb-color lighten-3 pt-4">
            <div class="footer-copyright text-center py-3"></div>
        </footer>

    </div>
</main>
</body >
</html >