var webpackMerge = require('webpack-merge');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var commonConfig = require('./webpack.common.js');
var helpers = require('./helpers');

module.exports = webpackMerge(commonConfig, {
    devtool: 'cheap-module-eval-source-map',

    output: {
        path: helpers.root('dist'),
<<<<<<< HEAD
        publicPath: '/${context.path}-${project.version}/views/angular2/',
=======
        publicPath: '/ws-java4web-0.0.1-SNAPSHOT/views/angular2/',
>>>>>>> 908f242d3ca7c84f3f50ec4545ec90e94740cf86
        filename: '[name].js',
        chunkFilename: '[id].chunk.js'
    },

    plugins: [
      new ExtractTextPlugin('[name].css')
    ],

    devServer: {
        historyApiFallback: true,
        stats: 'minimal'
    }
});
