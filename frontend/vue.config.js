/*
Vue configuration file
*/

module.exports = {
    devServer: {
        // set the port of this vue project
        port: 8080,
        // send all http request to a different path
        // the spring server is on port 8081
        proxy: 'http://localhost:8081'
    }

}

