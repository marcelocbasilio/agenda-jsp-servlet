PGDMP                         y            dbagenda    12.5    12.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24595    dbagenda    DATABASE     ?   CREATE DATABASE dbagenda WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE dbagenda;
                postgres    false                       0    0    DATABASE dbagenda    COMMENT     }   COMMENT ON DATABASE dbagenda IS 'Banco de dados para praticar a criação de uma agenda junto ao Professor José de Assis.';
                   postgres    false    2823                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            	           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            ?            1259    24598    contatos    TABLE     ?   CREATE TABLE public.contatos (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    fone character varying(15) NOT NULL,
    email character varying(100)
);
    DROP TABLE public.contatos;
       public         heap    postgres    false    3            ?            1259    24596    contatos_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.contatos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.contatos_id_seq;
       public          postgres    false    3    203            
           0    0    contatos_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.contatos_id_seq OWNED BY public.contatos.id;
          public          postgres    false    202            
           2604    24601    contatos id    DEFAULT     j   ALTER TABLE ONLY public.contatos ALTER COLUMN id SET DEFAULT nextval('public.contatos_id_seq'::regclass);
 :   ALTER TABLE public.contatos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203                      0    24598    contatos 
   TABLE DATA           9   COPY public.contatos (id, nome, fone, email) FROM stdin;
    public          postgres    false    203                       0    0    contatos_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.contatos_id_seq', 1, true);
          public          postgres    false    202            ?
           2606    24603    contatos pk_contato 
   CONSTRAINT     Q   ALTER TABLE ONLY public.contatos
    ADD CONSTRAINT pk_contato PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.contatos DROP CONSTRAINT pk_contato;
       public            postgres    false    203               J   x?3??M,JN??Wp?/JI?,?WpJ,?????԰0?T???47?5020?̅(LN??;??&f??%??r??qqq e??                     0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24595    dbagenda    DATABASE     ?   CREATE DATABASE dbagenda WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE dbagenda;
                postgres    false                       0    0    DATABASE dbagenda    COMMENT     }   COMMENT ON DATABASE dbagenda IS 'Banco de dados para praticar a criação de uma agenda junto ao Professor José de Assis.';
                   postgres    false    2823                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            	           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            ?            1259    24598    contatos    TABLE     ?   CREATE TABLE public.contatos (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    fone character varying(15) NOT NULL,
    email character varying(100)
);
    DROP TABLE public.contatos;
       public         heap    postgres    false    3            ?            1259    24596    contatos_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.contatos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.contatos_id_seq;
       public          postgres    false    3    203            
           0    0    contatos_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.contatos_id_seq OWNED BY public.contatos.id;
          public          postgres    false    202            
           2604    24601    contatos id    DEFAULT     j   ALTER TABLE ONLY public.contatos ALTER COLUMN id SET DEFAULT nextval('public.contatos_id_seq'::regclass);
 :   ALTER TABLE public.contatos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203                      0    24598    contatos 
   TABLE DATA           9   COPY public.contatos (id, nome, fone, email) FROM stdin;
    public          postgres    false    203   +                  0    0    contatos_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.contatos_id_seq', 1, true);
          public          postgres    false    202            ?
           2606    24603    contatos pk_contato 
   CONSTRAINT     Q   ALTER TABLE ONLY public.contatos
    ADD CONSTRAINT pk_contato PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.contatos DROP CONSTRAINT pk_contato;
       public            postgres    false    203           