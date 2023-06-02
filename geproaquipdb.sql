--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8 (Debian 14.8-1.pgdg110+1)
-- Dumped by pg_dump version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cadastro_fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cadastro_fornecedor (
    id integer NOT NULL,
    cnpj character varying(200),
    data date,
    email character varying(200),
    endereco character varying(200),
    fone character varying(30),
    nome character varying(200)
);


ALTER TABLE public.cadastro_fornecedor OWNER TO postgres;

--
-- Name: item_nf; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_nf (
    id integer NOT NULL,
    descricao character varying(100),
    quantidade integer,
    tipo character varying(100),
    nota_fiscal_id integer
);


ALTER TABLE public.item_nf OWNER TO postgres;

--
-- Name: item_tr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_tr (
    id integer NOT NULL,
    descricao character varying(100),
    quantidade integer,
    valor double precision,
    termo_referencia_id integer
);


ALTER TABLE public.item_tr OWNER TO postgres;

--
-- Name: nota_fiscal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nota_fiscal (
    id integer NOT NULL,
    data date,
    empenho boolean NOT NULL,
    liquidacao boolean NOT NULL,
    num_nf character varying(20),
    pagamento boolean NOT NULL,
    valor double precision,
    cadastro_forncedor_id integer,
    processo_pagamento_id integer
);


ALTER TABLE public.nota_fiscal OWNER TO postgres;

--
-- Name: processo_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.processo_pagamento (
    id integer NOT NULL,
    data_prot date,
    mes_competencia date,
    num_ata character varying(20),
    num_contrato character varying(100),
    num_protocolo character varying(20),
    objeto character varying(100),
    observacao character varying(300),
    status_ppagamento_id integer
);


ALTER TABLE public.processo_pagamento OWNER TO postgres;

--
-- Name: seq_cadastro_fornecedor_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_cadastro_fornecedor_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_cadastro_fornecedor_id OWNER TO postgres;

--
-- Name: seq_item_nf_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_item_nf_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_item_nf_id OWNER TO postgres;

--
-- Name: seq_item_tr_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_item_tr_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_item_tr_id OWNER TO postgres;

--
-- Name: seq_nota_fiscal_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_nota_fiscal_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_nota_fiscal_id OWNER TO postgres;

--
-- Name: seq_processo_pagamento_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_processo_pagamento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_processo_pagamento_id OWNER TO postgres;

--
-- Name: seq_setor_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_setor_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_setor_id OWNER TO postgres;

--
-- Name: seq_status_ppagamento_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_status_ppagamento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_status_ppagamento_id OWNER TO postgres;

--
-- Name: seq_status_tr_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_status_tr_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_status_tr_id OWNER TO postgres;

--
-- Name: seq_termo_referencia_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_termo_referencia_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_termo_referencia_id OWNER TO postgres;

--
-- Name: seq_unidade_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_unidade_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_unidade_id OWNER TO postgres;

--
-- Name: setor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.setor (
    id integer NOT NULL,
    descricao character varying(300),
    nome character varying(200),
    unidade_id integer
);


ALTER TABLE public.setor OWNER TO postgres;

--
-- Name: status_ppagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status_ppagamento (
    id integer NOT NULL,
    data date,
    ocorrencia character varying(300)
);


ALTER TABLE public.status_ppagamento OWNER TO postgres;

--
-- Name: status_tr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status_tr (
    id integer NOT NULL,
    andamento character varying(200),
    data date
);


ALTER TABLE public.status_tr OWNER TO postgres;

--
-- Name: termo_referencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.termo_referencia (
    id integer NOT NULL,
    abertura_processo date,
    num_processo character varying(50),
    numtr character varying(20),
    objeto character varying(100),
    tipo_processo character varying(100),
    status_tr_id integer
);


ALTER TABLE public.termo_referencia OWNER TO postgres;

--
-- Name: unidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.unidade (
    id integer NOT NULL,
    nome character varying(200)
);


ALTER TABLE public.unidade OWNER TO postgres;

--
-- Data for Name: cadastro_fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cadastro_fornecedor (id, cnpj, data, email, endereco, fone, nome) FROM stdin;
\.


--
-- Data for Name: item_nf; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item_nf (id, descricao, quantidade, tipo, nota_fiscal_id) FROM stdin;
\.


--
-- Data for Name: item_tr; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item_tr (id, descricao, quantidade, valor, termo_referencia_id) FROM stdin;
\.


--
-- Data for Name: nota_fiscal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nota_fiscal (id, data, empenho, liquidacao, num_nf, pagamento, valor, cadastro_forncedor_id, processo_pagamento_id) FROM stdin;
\.


--
-- Data for Name: processo_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.processo_pagamento (id, data_prot, mes_competencia, num_ata, num_contrato, num_protocolo, objeto, observacao, status_ppagamento_id) FROM stdin;
\.


--
-- Data for Name: setor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.setor (id, descricao, nome, unidade_id) FROM stdin;
\.


--
-- Data for Name: status_ppagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.status_ppagamento (id, data, ocorrencia) FROM stdin;
\.


--
-- Data for Name: status_tr; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.status_tr (id, andamento, data) FROM stdin;
\.


--
-- Data for Name: termo_referencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.termo_referencia (id, abertura_processo, num_processo, numtr, objeto, tipo_processo, status_tr_id) FROM stdin;
\.


--
-- Data for Name: unidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.unidade (id, nome) FROM stdin;
\.


--
-- Name: seq_cadastro_fornecedor_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_cadastro_fornecedor_id', 1, false);


--
-- Name: seq_item_nf_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_item_nf_id', 1, false);


--
-- Name: seq_item_tr_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_item_tr_id', 1, false);


--
-- Name: seq_nota_fiscal_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_nota_fiscal_id', 1, false);


--
-- Name: seq_processo_pagamento_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_processo_pagamento_id', 1, false);


--
-- Name: seq_setor_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_setor_id', 1, false);


--
-- Name: seq_status_ppagamento_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_status_ppagamento_id', 1, false);


--
-- Name: seq_status_tr_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_status_tr_id', 1, false);


--
-- Name: seq_termo_referencia_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_termo_referencia_id', 1, false);


--
-- Name: seq_unidade_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_unidade_id', 1, false);


--
-- Name: cadastro_fornecedor cadastro_fornecedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cadastro_fornecedor
    ADD CONSTRAINT cadastro_fornecedor_pkey PRIMARY KEY (id);


--
-- Name: item_nf item_nf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_nf
    ADD CONSTRAINT item_nf_pkey PRIMARY KEY (id);


--
-- Name: item_tr item_tr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_tr
    ADD CONSTRAINT item_tr_pkey PRIMARY KEY (id);


--
-- Name: nota_fiscal nota_fiscal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_fiscal
    ADD CONSTRAINT nota_fiscal_pkey PRIMARY KEY (id);


--
-- Name: processo_pagamento processo_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.processo_pagamento
    ADD CONSTRAINT processo_pagamento_pkey PRIMARY KEY (id);


--
-- Name: setor setor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setor
    ADD CONSTRAINT setor_pkey PRIMARY KEY (id);


--
-- Name: status_ppagamento status_ppagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_ppagamento
    ADD CONSTRAINT status_ppagamento_pkey PRIMARY KEY (id);


--
-- Name: status_tr status_tr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_tr
    ADD CONSTRAINT status_tr_pkey PRIMARY KEY (id);


--
-- Name: termo_referencia termo_referencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.termo_referencia
    ADD CONSTRAINT termo_referencia_pkey PRIMARY KEY (id);


--
-- Name: unidade unidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.unidade
    ADD CONSTRAINT unidade_pkey PRIMARY KEY (id);


--
-- Name: nota_fiscal fk10tjjtrtp3x75r27h7bijwa9i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_fiscal
    ADD CONSTRAINT fk10tjjtrtp3x75r27h7bijwa9i FOREIGN KEY (processo_pagamento_id) REFERENCES public.processo_pagamento(id);


--
-- Name: item_nf fk2us7dsbi9cyp1hp8xjj5hmcb4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_nf
    ADD CONSTRAINT fk2us7dsbi9cyp1hp8xjj5hmcb4 FOREIGN KEY (nota_fiscal_id) REFERENCES public.nota_fiscal(id);


--
-- Name: nota_fiscal fk4lhto0dibrw9ben2vepw9jq4t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nota_fiscal
    ADD CONSTRAINT fk4lhto0dibrw9ben2vepw9jq4t FOREIGN KEY (cadastro_forncedor_id) REFERENCES public.cadastro_fornecedor(id);


--
-- Name: termo_referencia fk7lpakuja54ssc62g8scqf8oj8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.termo_referencia
    ADD CONSTRAINT fk7lpakuja54ssc62g8scqf8oj8 FOREIGN KEY (status_tr_id) REFERENCES public.status_tr(id);


--
-- Name: setor fkfneaqt0n1uti267y02rkisasy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.setor
    ADD CONSTRAINT fkfneaqt0n1uti267y02rkisasy FOREIGN KEY (unidade_id) REFERENCES public.unidade(id);


--
-- Name: item_tr fknekuqm9kwspnvx991c7bm2me1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_tr
    ADD CONSTRAINT fknekuqm9kwspnvx991c7bm2me1 FOREIGN KEY (termo_referencia_id) REFERENCES public.termo_referencia(id);


--
-- Name: processo_pagamento fkqrwtsgu8bsoo33rvlvdjglf1j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.processo_pagamento
    ADD CONSTRAINT fkqrwtsgu8bsoo33rvlvdjglf1j FOREIGN KEY (status_ppagamento_id) REFERENCES public.status_ppagamento(id);


--
-- PostgreSQL database dump complete
--

