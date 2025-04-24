package main

import (
	"fmt"
	"io"
	"net/http"
)

func main() {
	config := loadConfig("application.yaml")
	fmt.Println("Server port is: ", config.Server.Port)

	http.HandleFunc("/", getRoot)

	_ = http.ListenAndServe(":8080", nil)
}

func getRoot(w http.ResponseWriter, r *http.Request) {
	fmt.Printf("got / request\n")
	io.WriteString(w, "This is my website!\n")
}
