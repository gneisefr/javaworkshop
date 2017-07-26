var webpack = require('webpack');
var webpackMerge = require('webpack-merge');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var commonConfig = require('./webpack.common.js');
var helpers = require('./helpers');

const ENV = process.env.NODE_ENV = process.env.ENV = 'production';

module.exports = webpackMerge(commonConfig, {
    devtool: 'source-map',

    output: {
        path: helpers.root('dist'),
<<<<<<< HEAD
        publicPath: '/${context.path}-${project.version}/views/angular2/',
=======
        publicPath: '/ws-java4web-0.0.1-SNAPSHOT/views/angular2/',
>>>>>>> 908f242d3ca7c84f3f50ec4545ec90e94740cf86
        filename: '[name].[hash].js',
        chunkFilename: '[id].[hash].chunk.js'
    },

    plugins: [
      new webpack.NoEmitOnErrorsPlugin(),
      new webpack.optimize.UglifyJsPlugin({ // https://github.com/angular/angular/issues/10618
          mangle: {
              keep_fnames: true
          }
      }),
      new ExtractTextPlugin('[name].[hash].css'),
      new webpack.DefinePlugin({
          'process.env': {
              'ENV': JSON.stringify(ENV)
          }
      }),
      new webpack.LoaderOptionsPlugin({
          htmlLoader: {
              minimize: false // workaround for ng2
          }
      })
    ]
});

