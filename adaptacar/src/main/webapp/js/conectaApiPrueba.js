var idPostGlobal = 1;

$(document).ready(function () {
    var paramstr = window.location.search.substr(1);
    var paramId = paramstr.split("=");
    idPostGlobal = paramId[1];
});

//crea Navbar
function navbar() {
    let nav = `
    <!-- Navbar content -->
        <div class="container-fluid">
            <div class="row">
                <!-- Logotipo -->
                <div class="col-xs-5 col-sm-7 col-md-8 col-lg-9 col-xl-9">
                    <a class="navbar-brand" href="index.html"><img src="img/AdaptaCarLogo.png" id="logo"></a>
                    <img src="img/AdaptacarNombre.png" id="tituloWed">
                </div>

                <!-- Boton inicio sesion-->
                <div class="col-xs-5 col-sm-5 col-md-4 col-lg-3 col-xl-3">
                    <button type="button" class="btn btn-outline-info btn-sm" data-toggle="modal"
                        data-target="#ventanaInicioSesion">
                        Iniciar sesion
                    </button>
                    <!-- Modal Inicio sesion -->
                    <div class="modal fade" id="ventanaInicioSesion" data-backdrop="static" data-keyboard="false"
                        tabindex="-1" aria-labelledby="ventanaInicioSesionLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="ventanaInicioSesionLabel">Inicio Sesión</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                                <form class="form-signin">
                                    <!-- DIRECCIÓN DE CORREO ELECTRÓNICO -->
                                    <div class="form-label-group">
                                        <input type="email" id="inputEmail" class="form-control"
                                            placeholder="Dirección de correo electrónico" required autofocus>
                                        <label for="inputEmail">Dirección de correo electrónico</label>
                                    </div>
                                    <!-- CONTRASEÑA -->
                                    <div class="form-label-group">
                                        <input type="password" id="inputPassword" class="form-control"
                                            placeholder="Password" required>
                                        <label for="inputPassword">Contraseña</label>
                                    </div>
                                    <!-- RECORDAR CONTRASEÑA -->
                                    <div class="custom-control custom-checkbox mb-3">
                                        <input type="checkbox" class="custom-control-input" id="customCheck1">
                                        <label class="custom-control-label" for="customCheck1">Recordar
                                            contraseña</label>
                                    </div>
                                    <!-- INICIAR SESIÓN -->
                                    <a href="indexRegistrado.html" class="ad-btn" type="submit">Iniciar sesión</a>
                                </form>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" data-dismiss="modal" aria-label="Close" data-toggle="modal"
                                    data-target="#ventanaRegistro">Nuevo por aquí? Regístrate</a>
                                <!--<a class="dropdown-item" href="#">Se te olvidó tu contraseña?</a>-->
                                <br>
                            </div>
                        </div>
                    </div>

                    <!-- Boton Registro -->
                    <button type="button" class="btn btn-outline-info btn-sm" data-toggle="modal"
                        data-target="#ventanaRegistro">
                        Registrarse
                    </button>
                    <!-- Modal Registro-->
                    <div class="modal fade" id="ventanaRegistro" tabindex="-1" role="dialog"
                        aria-labelledby="ventanaRegistroTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="ventanaRegistroTitle">Registrarse</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>

                                <form class="form-signin">
                                    <div class="form-label-group">
                                        <input type="text" id="inputUserame" class="form-control" placeholder="Nombre"
                                            required autofocus>
                                        <label for="inputUserame">Nombre</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="text" id="inputApellidos" class="form-control"
                                            placeholder="Apellidos" required>
                                        <label for="inputApellidos">Apellidos</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="text" id="inputCorreo" class="form-control"
                                            placeholder="Email" required>
                                        <label for="inputCorreo">Email</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="text" id="inputTelf" class="form-control" placeholder="Telf"
                                            required>
                                        <label for="inputTelf">Telefono</label>
                                    </div>

                                    <hr>

                                    <div class="form-label-group">
                                        <input type="password" id="inputRegisPassword" class="form-control"
                                            placeholder="Password" required>
                                        <label for="inputRegisPassword">Contraseña</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="password" id="inputConfirmPassword" class="form-control"
                                            placeholder="Password" required>
                                        <label for="inputConfirmPassword">Confirmar contraseña</label>
                                    </div>
                                    <button class="ad-btn" type="submit">Registrarse</button>
                                </form>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" type="submit" data-dismiss="modal" aria-label="Close"
                                    data-toggle="modal" data-target="#ventanaInicioSesion">Iniciar sesión</a>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Barra Busqueda -->
                <div
                    class="col-xm-10 offset-xm-2 col-sm-9 offset-sm-2 col-md-8 offset-md-2 col-lg-6 offset-lg-3 col-xl-6 offset-xl-3">
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" id="mySearch" type="search" placeholder="Buscar" onkeyup="buscador()" aria-label="Buscar">
                        <button class="btn btn-outline-info my-2 my-sm-0" type="submit" onclick="buscador()">Buscar</button>
                    </form>
                </div>
            </div>
        </div>
    `;
    document.getElementById('navbar').innerHTML = nav;
}

//Lista todos los anuncios sin orden especifico
function listaAnuncios() {
    fetch('http://localhost:8080/api/posts')
        .then(response => response.json())
        .then(anuncios => {
            let html = '';
            let title = `<p><i class="fas fa-exclamation-circle"></i> Coloque el ratón sobre los códigos de adaptación para ver la descripción.</p>
                <div class="row" id="ads"></div>`;

            anuncios.forEach(anuncio => {

                let adapt = '';
                anuncio.adaptaciones.forEach(adaptacion => {
                    adapt += `
                        <span class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</span>
                    `;
                });

                let image = returnImage(anuncio);

                html += `
                    <div class="col-xs-12 col-md-6 col-lg-4 post">
                        <div class="card rounded">
                            <div class="card-image">
                                <span class="card-notify-badge">${anuncio.precio} €</span>
                                <span class="card-notify-year">${anuncio.anyo}</span>
                                <div class="imgHeight">
                                    <img class="img-fluid"
                                        src="../resources/static/images/${image}"
                                    />
                                </div>
                            </div>
                            <div><p>Adaptaciones</p></div>
                            <div class="card-image-overlay m-auto" id="adaptaciones${anuncio.id}">
                                ${adapt}
                            </div>
                            
                            <div class="card-body text-center">
                                <div class="ad-title m-auto">
                                    <h5>${anuncio.coche.marca} ${anuncio.coche.modelo}</h5>
                                </div>
                                <a class="ad-btn" href="post.html?id=${anuncio.id}">Ver detalles</a>
                            </div>
                        </div>
                    </div>
                `;

            });
            document.getElementById('main').innerHTML = title;
            document.getElementById('ads').innerHTML = html;
        });
}

//------------------------------------------------------ORDENAR ANUNCIOS

//Funcion Ordenar sort por publicacion
function porFecha_publiDes(a, b) {
    if (a.fecha_publi === b.fecha_publi) return 0;
    if (a.fecha_publi > b.fecha_publi) return 1;
    else return -1;
}
//Funcion Ordenar por precio Des
function porPrecioDes(a, b) {
    if (a.precio === b.precio) return 0;
    if (a.precio > b.precio) return 1;
    else return -1;
}
//Funcion Ordenar por precio Asc
function porPrecioAsc(a, b) {
    if (a.precio === b.precio) return 0;
    if (a.precio > b.precio) return -1;
    else return 1;
}
//Funcion Ordenar año Des
function porAnyoDes(a, b) {
    if (a.anyo === b.anyo) return 0;
    if (a.anyo > b.anyo) return 1;
    else return -1;
}
//Funcion Ordenar año Asc
function porAnyoAsc(a, b) {
    if (a.anyo === b.anyo) return 0;
    if (a.anyo > b.anyo) return -1;
    else return 1;
}
//Funcion Kilometros Des
function porKilometrosDesc(a, b) {
    if (a.kilometros === b.kilometros) return 0;
    if (a.kilometros > b.kilometros) return 1;
    else return -1;
}
//Funcion Kilometros Asc
function porKilometrosAsc(a, b) {
    if (a.kilometros === b.kilometros) return 0;
    if (a.kilometros > b.kilometros) return -1;
    else return 1;
}
function listaAnunciosOrden(param) {
    fetch('http://localhost:8080/api/posts')
        .then(response => response.json())
        .then(anuncios => {
            let html = '';
            let title = `
        <p><i class="fas fa-exclamation-circle"></i> Coloque el ratón sobre los códigos de adaptación para ver la descripción.</p> 
        <div class="row" id="ads"></div>`;

            switch (param) {

                case 'novedades':
                    anuncios.sort(porFecha_publiDes);
                    break;

                case 'precioDes':
                    anuncios.sort(porPrecioDes);
                    break;

                case 'precioAsc':
                    anuncios.sort(porPrecioAsc);
                    break;

                case 'anyoAsc':
                    anuncios.sort(porAnyoAsc);
                    break;

                case 'anyoDes':
                    anuncios.sort(porAnyoDes);
                    break;

                case 'kilometrosDes':
                    anuncios.reverse().sort(porKilometrosDesc);
                    break;

                case 'kilometrosAsc':
                    anuncios.sort(porKilometrosAsc);
                    break;

                default:
                    break;
            }

            anuncios.reverse().forEach(anuncio => {

                let adapt = '';

                anuncio.adaptaciones.forEach(adaptacion => {
                    adapt += `
                    <span class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</span>
                `;
                });

                let image = returnImage(anuncio);

                html += `
                <div class="col-xs-12 col-md-6 col-lg-4 post">
                    <div class="card rounded">
                        <div class="card-image">
                            <span class="card-notify-badge">${anuncio.precio} €</span>
                            <span class="card-notify-year">${anuncio.anyo}</span>
                            <div class="imgHeight">
                                    <img class="img-fluid"
                                        src="../resources/static/images/${image}"
                                    />
                                </div>
                        </div>
                        <div class="card-image-overlay m-auto" id="adaptaciones${anuncio.id}">
                            ${adapt}
                        </div>
                        <div class="card-body text-center">
                            <div class="ad-title m-auto">
                                <h5>${anuncio.coche.marca} ${anuncio.coche.modelo}</h5>
                            </div>
                            <a class="ad-btn" href="post.html?id=${anuncio.id}">Ver detalles</a>
                        </div>
                    </div>
                </div>
                `;

            });
            document.getElementById('main').innerHTML = title;
            document.getElementById('ads').innerHTML = html;

        });
}

//-------------------------FUNCIONES POST.HTML INSERTA LOS DIVERSOS ATRIBUTOS DEL ANUNCIO

//Coje imagenes array ANUNCIO
function returnImage(anuncio) {
    let image = '';
    let i = 0;
    anuncio.imagenes.forEach(foto => {
        if (i == 0) {
            image += `${foto.urlFoto}`;
            i++;
        }
    });
    return image;
}

//FOTOS
function listaFotos() {
    fetch('http://localhost:8080/api/imagenesPost')
        .then(response => response.json())
        .then(fotos => {
            let nFotos = '';
            let fotosLista = '';
            let i = 0;
            fotos.forEach(foto => {

                if (foto.idpost == idPostGlobal) {

                    if (i == 0) {
                        nFotos += `
                            <li data-target="#carouselExampleIndicators" data-slide-to="`+ i + `" class="active"></li>
                        `;
                    } else {
                        nFotos += `
                            <li data-target="#carouselExampleIndicators" data-slide-to="`+ i + `"></li>
                        `;
                    }

                    if (i == 0) {
                        fotosLista += `
                                <div class="carousel-item active">
                                    <img class="d-block w-100"
                                        src="../resources/static/images/${foto.urlFoto}">
                                </div>
                            `;
                    } else {
                        fotosLista += `
                                <div class="carousel-item">
                                    <img class="d-block w-100"
                                        src="../resources/static/images/${foto.urlFoto}">
                                </div>
                            `;
                    }
                    i++;
                }

                //});
            });
            document.getElementById('numeroFotos').innerHTML = nFotos;
            document.getElementById('fotos').innerHTML = fotosLista;
        });

}

//ATRIBUTOS COCHE
function listaTitulosCoche() {
    fetch('http://localhost:8080/api/posts')
        .then(response => response.json())
        .then(anuncios => {
            let tituloCoche = '';
            let atributos1 = '';
            let atributos2 = '';
            let adapt = '';
            let descripcion = '';
            let fechaLugar = '';

            anuncios.forEach(anuncio => {
                if (anuncio.id == idPostGlobal) {

                    tituloCoche += `
                    <h3 class="card-title">${anuncio.coche.marca}</h3>
                    <h3 class="card-title">${anuncio.coche.modelo}</h3>
                    <h3 class="card-title">${anuncio.anyo}</h3>
                    <h2>${anuncio.precio}€</h2>
                    
                `;
                    let motorValue = anuncio.motor.cilindrada.substr(0, 1) + "." + anuncio.motor.cilindrada.substr(1, 1);

                    atributos1 += `        
                    <div>
                        <i class="fas fa-car-side"></i>
                        <br>
                        <span>${anuncio.carroceria.tipoCarroceria}</span>
                    </div>
                    <div>
                        <i class="fas fa-tachometer-alt"></i>
                        <br>
                        <span>${anuncio.kms} Km</span>
                    </div>
                    <div>
                        <i class="fas fa-gas-pump"></i>
                        <br>
                        <span>${anuncio.combustible.tipoCombustible}</span>
                    </div>
                    <div>
                        <img src="img/noun_Piston_963378.svg" alt="" height="40">
                        <br>
                        <span>${motorValue} ${anuncio.cv}CV</span>
                    </div>        
                `;
                    let cambio;
                    if (anuncio.embrague == false) {
                        cambio = 'Manual';
                    } else {
                        cambio = 'Automático';
                    }

                    atributos2 += `
                    <div>
                        <img src="img/noun_Seat_2522171.svg" alt="" height="40">
                        <br>
                        <span>Plazas ${anuncio.plazas.plazas}</span>
                    </div>
                    <div>
                        <img src="img/noun_Door_809306.svg" alt="" height="40">
                        <br>
                        <span>Puertas ${anuncio.puertas.puertas}</span>
                    </div>
                    <div>
                        <img src="img/noun_transmission_809309.svg" alt="" height="40">
                        <br>
                        <span>${cambio}</span>
                    </div>
                    <div>
                        <img src="img/noun_Differential_809293.svg" alt="" height="40">
                        <br>
                        <span>${anuncio.traccion.tipoTraccion}</span>
                    </div>
                `;

                    anuncio.adaptaciones.forEach(adaptacion => {
                        adapt += `
                  <span class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</span>
                `;
                    });
                    descripcion += `
                    <p class="card-text">${anuncio.descripcion}</p>
                `;

                    fechaLugar += `
                    <hr>
                    <p>${anuncio.fecha_publi}</p>
                    <hr>
                    <p><i class="fas fa-map-marker-alt"></i> ${anuncio.municipio.municipio}</p>

                `;

                }

            });
            document.getElementById('tituloCoche').innerHTML = tituloCoche;
            document.getElementById('atributos').innerHTML = atributos1;
            document.getElementById('atributos2').innerHTML = atributos2;
            document.getElementById('adaptacionesPost').innerHTML = adapt;
            document.getElementById('desc').innerHTML = descripcion;
            document.getElementById('fechaLugar').innerHTML = fechaLugar;

        });

}

//-------------------------FUNCION MAPS
function iniciarMap() {

    fetch('http://localhost:8080/api/posts')
        .then(response => response.json())
        .then(anuncios => {
            anuncios.forEach(anuncio => {
                if (anuncio.id == idPostGlobal) {

                    var coord = { lat: parseFloat(anuncio.municipio.latitud), lng: parseFloat(anuncio.municipio.longitud) };
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 14,
                        center: coord
                    });
                    var marker = new google.maps.Marker({
                        position: coord,
                        map: map
                    });
                }
            });
        });
}

//-------------------------FUNCION LISENER MARCA -> MODELO
function seleccionaMarca() {
    var x = document.getElementById("marca").value;
    document.getElementById("modelo").disabled = false;

    //MODELO
    fetch('http://localhost:8080/api/coches')
        .then(response => response.json())
        .then(coches => {
            let chs = '<option selected="true" disabled="disabled">Modelo</option>';
            coches.forEach(coche => {
                if (coche.marca === x) {
                    chs += `
                    <option value="${coche.id}">${coche.modelo}</option>     
                `;
                }
            });
            document.getElementById('modelo').innerHTML = chs;
        });
}

//-------------------------FUNCION LISENER PROVINCIA -> MUNICIPIO
function seleccionaProvincia() {
    var y = document.getElementById("provincias").value;
    document.getElementById("municipios").disabled = false;

    //MUNICIPIOS
    fetch('http://localhost:8080/api/municipios')
        .then(response => response.json())
        .then(municipios => {
            let mncp = '<option selected="true" disabled="disabled">Municipio</option>';
            municipios.forEach(municipio => {
                if (municipio.provincia.id == y) {
                    mncp += `
                    <option value="${municipio.id}">${municipio.municipio} </option>     
                `;
                }
            });
            document.getElementById('municipios').innerHTML = mncp;
        });
}

//-------------------------FUNCIONES MUESTRA FILTROS Y CREAPOST.HTML INSERTA LOS DIVERSOS ATRIBUTOS DEL ANUNCIO
function listaAtributos() {
    //MARCA
    fetch('http://localhost:8080/api/coches')
        .then(response => response.json())
        .then(marcas => {
            let mrc = '<option selected="true" disabled="disabled">Marca</option>';
            let aux = ''
            marcas.forEach(marca => {
                if (aux === marca.marca) {

                } else {
                    aux = marca.marca;
                    mrc += `
                    <option value="${marca.marca}">${marca.marca}</option>     
                `;
                }
            });
            document.getElementById('marca').innerHTML = mrc;
        });

    //CILINDRADA
    fetch('http://localhost:8080/api/motores')
        .then(response => response.json())
        .then(motores => {
            let cc = '<option selected="true" disabled="disabled">Cilindrada</option>';
            motores.forEach(motor => {
                cc += `
                <option value="${motor.id}">${motor.cilindrada}</option>     
            `;
            });
            document.getElementById('cilindrada').innerHTML = cc;
        });

    //COMBUSTIBLE   
    fetch('http://localhost:8080/api/combustibles')
        .then(response => response.json())
        .then(combustibles => {
            let cmbst = '<option selected="true" disabled="disabled">Combustible</option>';
            combustibles.forEach(combustible => {
                cmbst += `
                <option value="${combustible.id}">${combustible.tipoCombustible}</option>     
            `;
            });
            document.getElementById('combustible').innerHTML = cmbst;
        });

    //TRACCIONES
    fetch('http://localhost:8080/api/tracciones')
        .then(response => response.json())
        .then(tracciones => {
            let trac = '<option selected="true" disabled="disabled">Tracción</option>';
            tracciones.forEach(traccion => {
                trac += `
                <option value="${traccion.id}">${traccion.tipoTraccion}</option>     
            `;
            });
            document.getElementById('traccion').innerHTML = trac;
        });

    //COLORES
    fetch('http://localhost:8080/api/colores')
        .then(response => response.json())
        .then(colores => {
            let clr = '<option selected="true" disabled="disabled">Color</option>';
            colores.forEach(color => {
                clr += `
                <option value="${color.id}">${color.nombre}</option>     
            `;
            });
            document.getElementById('color').innerHTML = clr;
        });

    //CARROCERIA
    fetch('http://localhost:8080/api/carrocerias')
        .then(response => response.json())
        .then(carrocerias => {
            let crc = '<option selected="true" disabled="disabled">Carrocería</option>';
            carrocerias.forEach(carroceria => {
                crc += `
                <option value="${carroceria.id}">${carroceria.tipoCarroceria}</option>     
            `;
            });
            document.getElementById('carroceria').innerHTML = crc;
        });

    //NUMERO PLAZAS
    fetch('http://localhost:8080/api/plazas')
        .then(response => response.json())
        .then(plazas => {
            let plz = '<option selected="true" disabled="disabled">Número de plazas</option>';
            plazas.forEach(plaza => {
                if (plaza.id == 1) {
                    plz += `
                    <option value="${plaza.id}">${plaza.plazas} plaza</option>     
                `
                        ;
                } else {
                    plz += `
                    <option value="${plaza.id}">${plaza.plazas} plazas</option>     
                `
                };
            });
            document.getElementById('plazas').innerHTML = plz;
        });

    //NUMERO PUERTAS
    fetch('http://localhost:8080/api/puertas')
        .then(response => response.json())
        .then(puertas => {
            let prts = '<option selected="true" disabled="disabled">Número de puertas</option>';
            puertas.forEach(puerta => {

                prts += `
                    <option value="${puerta.id}">${puerta.puertas} puertas</option>     
                `

            });
            document.getElementById('puertas').innerHTML = prts;
        });

    //ADAPTACIONES
    fetch('http://localhost:8080/api/adaptaciones')
        .then(response => response.json())
        .then(adaptaciones => {
            let adapt = '<option selected="true" disabled="disabled">Adaptaciones</option>';
            adaptaciones.forEach(adaptacion => {

                adapt += `
                    <option value="${adaptacion.id}">${adaptacion.codigo}.${adaptacion.subcodigo} ${adaptacion.descripcion}</option>     
                `

            });
            document.getElementById('adaptaciones').innerHTML = adapt;
        });


    //PROVINCIAS 
    fetch('http://localhost:8080/api/provincias')
        .then(response => response.json())
        .then(provincias => {
            let prvn = '<option selected="true" disabled="disabled">Provincias</option>';
            provincias.forEach(provincia => {

                prvn += `
                    <option value="${provincia.id}">${provincia.provincia}</option>     
                `
            });
            document.getElementById('provincias').innerHTML = prvn;
        });

    //ADAPTACIONES
    fetch('http://localhost:8080/api/adaptaciones')
        .then(response => response.json())
        .then(adaptaciones => {
            let adapt = '';
            adaptaciones.forEach(adaptacion => {

                adapt += `
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" onchange="filtroadaptaciones()" id="${adaptacion.id}adapt" value="${adaptacion.id}">
                <label class="form-check-label" for="inlineCheckbox1" class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</label>
            </div>
                    
                `

            });
            document.getElementById('adaptacionesFiltro').innerHTML = adapt;
        });
}

//-------------------------FUNCIONES FILTRADO
//Filtro adaptaciones
function filtroadaptaciones() {
    let countadaptaciones = 0;
    let countRevis = 0;
    let urlFiltro = 'http://localhost:8080/api/postsporadaptaciones/';

    for (let i = 1; i < 52; i++) {

        var elemento = document.getElementById(i + "adapt");
        if (elemento.checked == true) {
            if (countadaptaciones == 0) {
                urlFiltro += elemento.value;
                countadaptaciones++;
            } else {
                urlFiltro += "," + elemento.value;
            }
        } else {
            countRevis++;
            if (countRevis == 51) {
                urlFiltro = 'http://localhost:8080/api/posts'
            }
        }
    }

    fetch(urlFiltro)
        .then(response => response.json())
        .then(anuncios => {
            let html = '';
            let title = `
            <p><i class="fas fa-exclamation-circle"></i> Coloque el ratón sobre los códigos de adaptación para ver la descripción.</p> 
            <div class="row" id="ads"></div>
            `;

            anuncios.reverse().forEach(anuncio => {

                let adapt = '';

                anuncio.adaptaciones.forEach(adaptacion => {
                    adapt += `
                <span class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</span>
                    `;
                });

                let image = returnImage(anuncio);

                html += `
            <div class="col-xs-12 col-md-6 col-lg-4 post">
                <div class="card rounded">
                    <div class="card-image">
                        <span class="card-notify-badge">${anuncio.precio} €</span>
                        <span class="card-notify-year">${anuncio.anyo}</span>
                        <div class="imgHeight">
                                <img class="img-fluid"
                                    src="../resources/static/images/${image}"
                                />
                            </div>
                    </div>
                    <div class="card-image-overlay m-auto" id="adaptaciones${anuncio.id}">
                        ${adapt}
                    </div>
                    <div class="card-body text-center">
                        <div class="ad-title m-auto">
                            <h5>${anuncio.coche.marca} ${anuncio.coche.modelo}</h5>
                        </div>
                        <a class="ad-btn" href="post.html?id=${anuncio.id}">Ver detalles</a>
                    </div>
                </div>
            </div>
                `;

            });
            document.getElementById('main').innerHTML = title;
            document.getElementById('ads').innerHTML = html;
        });
}

function filtradoAtributos() {

    let urlFiltro = 'http://localhost:8080/api/posts/get?';

    var pre = document.getElementById("input-precio").value;
    if (pre == 0) {
        //alert(pre)
        urlFiltro += 'precio=' + pre + '&precioCondition=greater';
    } else {
        urlFiltro += 'precio=' + (parseInt(pre) + 1) + '&precioCondition=less';
    }

    var mod = document.getElementById("modelo").value;
    if (mod === 'Modelo') {
        //alert('Modelo')
    } else {
        urlFiltro += '&coche=' + mod;
    }

    var ano = document.getElementById("input-ano").value;
    if (ano == 2021) {
        //alert(ano)//mostrar todo
    } else {
        urlFiltro += '&anyo=' + ano + '&anyoCondition=less';
    }

    var km = document.getElementById("input-km").value;
    if (km == 0) {
        //alert(km)//mostrar todo
    } else {
        urlFiltro += '&kms=' + (parseInt(km) + 1) + '&kmsCondition=less'; //menor que kms=9000&kmsCondition=less
    }

    var cv = document.getElementById("input-cv").value;
    if (cv == 49) {
        //alert(cv)//mostrar todo
    } else {
        urlFiltro += '&cv=' + cv + '&cvCondition=less';
    }

    var cil = document.getElementById("cilindrada").value;
    if (cil === 'Cilindrada') {
        //alert(cil)//mostrar todo
    } else {
        urlFiltro += "&motor=" + cil; //menor que kms=9000&kmsCondition=less
    }

    var com = document.getElementById("combustible").value;
    if (com === 'Combustible') {
        //alert(com)//mostrar todo
    } else {
        urlFiltro += "&combustible=" + com;
    }

    var tra = document.getElementById("traccion").value;
    if (tra === 'Tracción') {
        //alert(tra)//mostrar todo
    } else {
        urlFiltro += '&traccion=' + tra;
    }
    
    var emb = document.getElementById("embrague").value;
    if (emb === 'Embrague') {
        //alert(emb)//mostrar todo
    } else {
        switch (emb) {
            case 'false':
                urlFiltro += '&embrague=0';
                break;

            case 'true':
                urlFiltro += '&embrague=1';
                break;

            default:
                break;
        }
    }

    var car = document.getElementById("carroceria").value;
    if (car === 'Carrocería') {
        //alert(car)//mostrar todo
    } else {
        urlFiltro += '&carroceria=' + car;
    }

    var pla = document.getElementById("plazas").value;
    if (pla === 'Número de plazas') {
        //alert(pla)//mostrar todo
    } else {
        urlFiltro += '&plazas=' + pla;
    }

    var puer = document.getElementById("puertas").value;
    if (puer === 'Número de puertas') {
        //alert(puer)//mostrar todo
    } else {
        urlFiltro += '&puertas=' + (parseInt(puer) + 1);
    }

    var colr = document.getElementById("color").value;
    if (colr === 'Color') {
        //alert(colo)//mostrar todo
    } else {
        urlFiltro += '&color=' + colr;
    }

    fetch(urlFiltro)
        .then(response => response.json())
        .then(anuncios => {
            let html = '';
            let title = `<p><i class="fas fa-exclamation-circle"></i> Coloque el ratón sobre los códigos de adaptación para ver la descripción.</p> 
    <div class="row" id="ads"></div>`;

            anuncios.reverse().forEach(anuncio => {

                let adapt = '';

                anuncio.adaptaciones.forEach(adaptacion => {
                    adapt += `
                <span class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</span>
            `;
                });

                let image = returnImage(anuncio);

                html += `
            <div class="col-xs-12 col-md-6 col-lg-4 post">
                <div class="card rounded">
                    <div class="card-image">
                        <span class="card-notify-badge">${anuncio.precio} €</span>
                        <span class="card-notify-year">${anuncio.anyo}</span>
                        <div class="imgHeight">
                                <img class="img-fluid"
                                    src="../resources/static/images/${image}"
                                />
                            </div>
                    </div>
                    <div class="card-image-overlay m-auto" id="adaptaciones${anuncio.id}">
                        ${adapt}
                    </div>
                    <div class="card-body text-center">
                        <div class="ad-title m-auto">
                            <h5>${anuncio.coche.marca} ${anuncio.coche.modelo}</h5>
                        </div>
                        <a class="ad-btn" href="post.html?id=${anuncio.id}">Ver detalles</a>
                    </div>
                </div>
            </div>
            `;

            });
            document.getElementById('main').innerHTML = title;
            document.getElementById('ads').innerHTML = html;
        });
}

function buscador(){
    var key = document.getElementById("mySearch").value;
    var url ='http://localhost:8080/api/postsporkeyword/' + key;
    fetch(url)
        .then(response => response.json())
        .then(anuncios => {
            let html = '';
            let title = `<p><i class="fas fa-exclamation-circle"></i> Coloque el ratón sobre los códigos de adaptación para ver la descripción.</p>
                <div class="row" id="ads"></div>`;

            anuncios.forEach(anuncio => {

                let adapt = '';
                anuncio.adaptaciones.forEach(adaptacion => {
                    adapt += `
                        <span class="card-detail-badge" data-toggle="tooltip" data-placement="bottom" title="${adaptacion.descripcion}">${adaptacion.codigo}.${adaptacion.subcodigo}</span>
                    `;
                });

                let image = returnImage(anuncio);

                html += `
                    <div class="col-xs-12 col-md-6 col-lg-4 post">
                        <div class="card rounded">
                            <div class="card-image">
                                <span class="card-notify-badge">${anuncio.precio} €</span>
                                <span class="card-notify-year">${anuncio.anyo}</span>
                                <div class="imgHeight">
                                    <img class="img-fluid"
                                        src="../resources/static/images/${image}"
                                    />
                                </div>
                            </div>
                            <div><p>Adaptaciones</p></div>
                            <div class="card-image-overlay m-auto" id="adaptaciones${anuncio.id}">
                                ${adapt}
                            </div>
                            
                            <div class="card-body text-center">
                                <div class="ad-title m-auto">
                                    <h5>${anuncio.coche.marca} ${anuncio.coche.modelo}</h5>
                                </div>
                                <a class="ad-btn" href="post.html?id=${anuncio.id}">Ver detalles</a>
                            </div>
                        </div>
                    </div>
                `;

            });
            document.getElementById('main').innerHTML = title;
            document.getElementById('ads').innerHTML = html;
        });
}

function insertaPost() {
    let d = new Date();
    let fecha ="" + d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
    let hora = "" + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    let fechaHora = fecha + " " + hora;
  
    let traccion = $("#traccion").val().toString();
    let carroceria = $("#carroceria").val().toString();
    let color = $("#color").val().toString();
    let puertas = $("#puertas").val().toString();
    let idcoche = $("#modelo").val().toString();
    let plazas = $("#plazas").val().toString();
    let precio = document.getElementById("inputPrecio").value.toString();
    let descripcion = document.getElementById("exampleFormControlTextarea1").value.toString();
    let combustible = $("#combustible").val().toString();
    let provincia = $("#provincias").val().toString();
    let cilindrada = $("#cilindrada").val().toString();
    let municipios = $("#municipios").val().toString();
    let kms = $("#inputKm").val().toString();
    let adaptaciones = $("#adaptaciones").val().toString();
    let embrague = $("#embrague").val().toString();
    let anyo = $("#inputAnyo").val().toString();
    let cv = $("#inputCaballo").val().toString();
    let image = document.getElementById("file");
  
    let formdata = new FormData();
  
    formdata.append("fecha_publi", fechaHora);
    formdata.append("anyo", anyo);
    formdata.append("traccion", traccion);
    formdata.append("carroceria", carroceria);
    formdata.append("color", color);
    formdata.append("puertas", puertas);
    formdata.append("idcoche", idcoche);
    formdata.append("plazas", plazas);
    formdata.append("precio", precio);
    formdata.append("descripcion", descripcion);
    formdata.append("combustible", combustible);
    formdata.append("provincia", provincia);
    formdata.append("motorCC", cilindrada);
    formdata.append("municipio", municipios);
    formdata.append("kms", kms);
    formdata.append("adaptaciones", adaptaciones);
    formdata.append("embrague", embrague);
    formdata.append("cv", cv);
    
    for (const file of image.files) {
      formdata.append("imagenes[]", file, file.name);
    }
  
    var requestOptions = {
      method: "POST",
      body: formdata,
    };
  
    fetch("http://localhost:8080/api/posts", requestOptions)
      .then((response) => response.text())
      .then((result) => console.log(result))
      .catch((error) => console.log("error", error));
  }

//FUNCIONES DE CARGA DE PAGINA
function funcionesPost() {
    //navbar();
    listaTitulosCoche();
    listaAtributos();
    listaFotos();
}
function funcionesIndex() {
    navbar();
    listaAtributos();
    listaAnuncios();
}
function funcionesCreaPost() {
    listaAtributos();
}
function indexRegistrado() {
    listaAtributos();
    listaAnuncios();
}

// function funcionesPostRegistrado(){
//     listaTitulosCoche();
//     listaAtributos();
//     listaFotos();
// }