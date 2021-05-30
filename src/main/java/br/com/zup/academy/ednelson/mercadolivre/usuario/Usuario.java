package br.com.zup.academy.ednelson.mercadolivre.usuario;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.zup.academy.ednelson.mercadolivre.security.SenhaLimpa;

@Entity
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String senha;
	private LocalDateTime instanteDoCadastro;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis;
	
	public Usuario(String email, SenhaLimpa senhaLimpa) {
			this.email = email;
			this.senha = senhaLimpa.hash();
			this.instanteDoCadastro = LocalDateTime.now();
	}

	@Deprecated
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
