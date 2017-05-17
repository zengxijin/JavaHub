module.exports = {
  entry: __dirname + "/app.js",
  output: {
    path: __dirname+"/dist",
    filename: "bundle.js"
  },
    resolve: {
        extensions: [ '.js', '.jsx']
    },
    module: {
        loaders: [
            {
                test: /\.jsx$/,
                loaders: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    cacheDirectory: true,
                    presets: ['react','es2015']
                }
            }
        ]
    }
}