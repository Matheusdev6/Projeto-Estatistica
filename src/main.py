from fastapi import FastAPI

app = FastAPI()

@app.get("/fastapitest")
def read_root():
    return {"message":"Hello, FastAPI!"}