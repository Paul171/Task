'use strict';

var gulp = require('gulp');
var sass = require('gulp-sass');
var del  = require('del');
var jshint= require('gulp-jshint');
var packageJSON  = require('./package');
var jshintConfig = packageJSON.jshintConfig;

gulp.task('sass',function(){
	gulp.src('scss/*.scss')
		.pipe(sass())
		.pipe(gulp.dest('./css'));
});
gulp.task('clean',function(){
	del('./css/*');
});
gulp.task('hint',function(){
	return gulp.src('controller/*.js')
		.pipe(jshint(jshintConfig))
		.pipe(jshint.reporter('gulp-jshint-file-reporter', {
	      filename: __dirname + '/jshint-output.log'
	    }));
});
gulp.task('default',['clean'],function(){
	gulp.watch('scss/*.scss',['sass']);
});