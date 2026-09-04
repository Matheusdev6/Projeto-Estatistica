import psycopg2
import os
from dotenv import load_dotenv

load_dotenv()

db_host = os.getenv("HOST")
db_port = os.getenv("PORT")
db_user = os.getenv("DB_USER")
db_password = os.getenv("DB_PASSWORD")
db_name = os.getenv("DATABASE")

def selectAll(): # colocar qual db quero posteriormente
    try:
        conn = psycopg2.connect(database = db_name,user = db_user,password = db_password,host = db_host, port = db_port)

        if(conn):
            print("connected")
        else:
            print("not conected")

        cursor = conn.cursor()

        cursor.execute("SELECT data, valor FROM public.taxa_selic;")

        data = cursor.fetchall()
        data = [x for x in data]

        conn.commit()    

        return data
    except Exception as e:
        conn.rollback()
        print(f"Error: {e}")
    finally:
        cursor.close()
        conn.close()
