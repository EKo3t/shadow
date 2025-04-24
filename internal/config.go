package main

import (
	"fmt"
	"os"

	"gopkg.in/yaml.v3"
)

type Config struct {
	Server struct {
		Port int `yaml:"port"`
	} `yaml:"server"`
}

func loadConfig(filename string) *Config {
	bytes, err := os.ReadFile(filename)
	check(err, fmt.Sprintf("Failed to open %s config", filename))

	var config Config
	err = yaml.Unmarshal(bytes, &config)
	check(err, "Failed to unmarshal yaml config")

	return &config
}

func check(e error, msg string) {
	if e != nil {
		fmt.Println(msg)
		panic(e)
	}
}
