package com.ivan.nikolov.cake

import org.scalatest.mockito.MockitoSugar

trait TestEnvironment 
  extends UserComponent
  with DaoComponent
  with DatabaseComponent
  with MigrationComponent
  with MockitoSugar {

  override val dao: Dao = mock[Dao]
  override val databaseService: DatabaseService = mock[DatabaseService]
  override val migrationService: MigrationService = mock[MigrationService]
  override val userService: UserService = mock[UserService]
}
